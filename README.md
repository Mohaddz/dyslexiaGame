# Dyslexia Farm
## Dyslexia Farm is a game that helps children who has spelling disabilities such as Dyslexia, to overcome this problem by practicing a lot of examples attractively. 

Many people around the world have learning disabilities it is due to genetics or neurobiological factors that affects part of the brain which affects the process of learning. 

People can have difficulty organizing information or difficulty on taking in information or acting with information. The problem of having difficulty is due to the brain structure where the neurons are not connected which results in these learning disorders.

One of the most popular learning disabilities is dyslexia which is the problem of difficulty with reading Our games will help people with the developmental reading disorder to improve their reading.


* The game is built using JavaFX for front-end, and SQL for back-end


Some screen shots of the game:

* Log in page:

![image](https://user-images.githubusercontent.com/93622996/228839584-99f8cdd7-d038-4ecd-ab8c-39f2f91dfc47.png)


This login page is built using JavaFX and is intended for the game. The page contains a login button, a welcome label, and two buttons for selecting English and Arabic languages. The login button allows the user to enter their username and password and checks for the user in the database in order to gain access to the game. The two language buttons allow users to switch between English and Arabic, allowing them to select the language they are most comfortable with. The page is designed to be children-friendly and intuitive, children’s users to access the game quickly and easily

* Main menu

![image](https://user-images.githubusercontent.com/93622996/228839927-86e31846-cd28-47c9-bf7b-4d69aad0bbbb.png)


This main menu contains four buttons, each intended for a different purpose. The first button is for the first game, allowing users to start playing Words Game. The second button is for the second game, allowing users to access Spelling Game. The third button is for reports, which show users their high scores for each game. The fourth button is an exit button, which allows users to quit the game. Each button is labeled clearly and is easily accessible, making it easy for users to navigate the main menu.


* Words game

Words game is a game that allows the player to differentiate between commonly mistaken words. The interface is intended to be child friendly with a calming background music and the player can choose between 3 levels of sounds whichever he is comfortable with. 

![image](https://user-images.githubusercontent.com/93622996/228840080-c9d84c1d-1db1-4f2b-b69e-fd44991876be.png)


* spilling game

This game is for children who have problems with letter’s sounds that affects the ability of spilling a word. The player also can choose between three levels of sounds easy, medium, hard, and a tab showing points and misses in real time.

![image](https://user-images.githubusercontent.com/93622996/228840161-c68f1e25-e827-4005-a4e2-91e7aee449a4.png)


* Ending Screen 

![image](https://user-images.githubusercontent.com/93622996/228840198-c17f1928-20f2-49da-bb1a-ff674d2b1468.png)



Report Page

![image](https://user-images.githubusercontent.com/93622996/228840227-dcd6223f-5105-4d9b-9881-510b6c4b65d4.png)



In the report page, it retreives the data from the database by using the user name as a key for the query


*Database

![image](https://user-images.githubusercontent.com/93622996/228840493-16fea405-adc8-4b25-a167-c1f3072a48e5.png)


The Database table that is being used in the project. All entities are self-explanatory, SP_MISSES and SP_POINTS are for storing the points for the first game, W_MISSES and W_POINTS are for words game, also dates are for the date that the high score record has been broken. 
