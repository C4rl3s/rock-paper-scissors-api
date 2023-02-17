--MOVE table values
INSERT INTO MOVE (move) VALUES ('Rock');
INSERT INTO MOVE (move) VALUES ('Paper');
INSERT INTO MOVE (move) VALUES ('Scissors');

--RULE table values
INSERT INTO RULE (player_move, computer_move, result) VALUES ('Rock', 'Rock', 'Draw');
INSERT INTO RULE (player_move, computer_move, result) VALUES ('Rock', 'Paper', 'Computer');
INSERT INTO RULE (player_move, computer_move, result) VALUES ('Rock', 'Scissors', 'Player');
INSERT INTO RULE (player_move, computer_move, result) VALUES ('Paper', 'Rock', 'Player');
INSERT INTO RULE (player_move, computer_move, result) VALUES ('Paper', 'Paper', 'Draw');
INSERT INTO RULE (player_move, computer_move, result) VALUES ('Paper', 'Scissors', 'Computer');
INSERT INTO RULE (player_move, computer_move, result) VALUES ('Scissors', 'Rock', 'Computer');
INSERT INTO RULE (player_move, computer_move, result) VALUES ('Scissors', 'Paper', 'Player');
INSERT INTO RULE (player_move, computer_move, result) VALUES ('Scissors', 'Scissors', 'Draw');

--MATCH table values
INSERT INTO MATCH (player_move, computer_move, result, match_datetime) VALUES ('Rock', 'Rock', 'Draw', '2023-01-28 15:30:00');
INSERT INTO MATCH (player_move, computer_move, result, match_datetime) VALUES ('Rock', 'Paper', 'Computer', '2023-01-28 15:31:00');
INSERT INTO MATCH (player_move, computer_move, result, match_datetime) VALUES ('Paper', 'Rock', 'Player', '2023-01-28 15:32:00');
INSERT INTO MATCH (player_move, computer_move, result, match_datetime) VALUES ('Scissors', 'Paper', 'Player', '2023-01-28 15:33:00');
INSERT INTO MATCH (player_move, computer_move, result, match_datetime) VALUES ('Scissors', 'Paper', 'Player', '2023-01-28 15:34:00');