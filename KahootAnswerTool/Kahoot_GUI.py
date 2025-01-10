### GUI (View)
import tkinter as tk
from tkinter import messagebox
import Kahoot_Tool

class KahootAnswerTool:
    def __init__(self, root):
        self.root = root
        self.root.title("Kahoot Answer Tool")

        # Text area for displaying questions and answers
        self.text_area = tk.Text(root, height=15, width=50)
        self.text_area.pack(pady=10)

        # Frame for input and buttons
        frame = tk.Frame(root)
        frame.pack()

        # Game ID input
        tk.Label(frame, text="Game ID:").grid(row=0, column=0, padx=5)
        self.game_id_entry = tk.Entry(frame, width=40)
        self.game_id_entry.grid(row=0, column=1, padx=5)

        # Buttons
        go_button = tk.Button(frame, text="Go!", command=self.fetch_answers)
        go_button.grid(row=0, column=2, padx=5)

        clear_button = tk.Button(frame, text="Clear!", command=self.clear_text)
        clear_button.grid(row=0, column=3, padx=5)

    def fetch_answers(self):
        game_id = self.game_id_entry.get().strip()
        if not game_id:
            messagebox.showwarning("Input Error", "Please enter a Game ID.")
            return

        try:
            # Call the kahootcheat module to fetch answers
            result = Kahoot_Tool.fetch_answers(game_id)
            result_string = str(result)
            print(result_string)
            self.text_area.delete(1.0, tk.END)
            self.text_area.insert(tk.END, result_string)
        except Exception as e:
            messagebox.showerror("Error", f"An error occurred: {e}")

    def clear_text(self):
        """Clear the text area."""
        self.text_area.delete(1.0, tk.END)
        self.game_id_entry.delete(0, tk.END)

if __name__ == "__main__":
    root = tk.Tk()
    app = KahootAnswerTool(root)
    root.mainloop()
