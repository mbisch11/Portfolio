import urllib.request as lmao
import json
import io




def questionfilter(ques_list):
    for i, q in enumerate(ques_list):
        if q.get("type") == "content":
            ques_list.pop(i)
    return ques_list


def getReturnString(queslist,pos_list):
    bigGuy = [] #io.StringIO()

    for q_index, q in enumerate(queslist):
        choices = q.get("choices",[])
        bigGuy.append("\nQuestion number: {}\n".format(q_index + 1))
        for ch_index, ch in enumerate(choices):
            if ch.get("correct") is True:
                bigGuy.append("Answer: {}\nPosition: {}\n".format(ch.get("answer"), pos_list[ch_index]))
        return "".join(bigGuy)

def fetch_answers(game_id):
    gameid = game_id
    url = "https://play.kahoot.it/rest/kahoots/" + gameid
        
    response = lmao.urlopen(url).read()
    data = json.loads(response)
    questions = data["questions"]
    position_list = ["Red", "Blue", "Yellow", "Green"]
    print(questions)
    questions = questionfilter(questions)
    returnString = getReturnString(questions,position_list)
    



#DO NOT TOUCH
#The following code is for running the script out of a terminal
#or if you're seeing this on github and wanna steal my code
'''
gameid = input("Enter game id: ")
url = "https://play.kahoot.it/rest/kahoots/" + gameid

response = lmao.urlopen(url).read()
data = json.loads(response)
questions = data["questions"]
position_list = ["Top Left", "Top Right", "Bottom Left", "Bottom Right"]

def questionfilter(ques_list):
        for i, q in enumerate(ques_list):
            if q.get("type") == "content":
                ques_list.pop(i)
        return ques_list

better_qs = questionfilter(questions)

for q_index, q in enumerate(better_qs):
    if q.get("type") == "quiz" or "multiple_select_quiz":
        print("\nQuestion number: {}".format(q_index + 1))
        
        # Loop through each choice in the question
        choices = q.get("choices", [])
        for ch_index, ch in enumerate(choices):
            if ch.get("correct") is True:
                print("Answer: {}\nPosition: {}".format(ch.get("answer"), position_list[ch_index]))
'''