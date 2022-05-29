// get the client
const mysql = require('mysql2');
 
// create the connection to database
const connection = mysql.createConnection({
  host: 'localhost',
  user: 'huntkingdom',
  password: 'huntkingdom',
  database: 'huntkingdom'
});
 
// simple query

// with placeholder



var express = require('express')
var app = express()
 
app.get('/', function (req, res) {
  connection.query(
  'SELECT * FROM `Users` ',
  function(err, results, fields) {
    res.json(results);
  }
); 
});

app.get('/getUser', function (req, res) {
connection.query(
  'SELECT * FROM `Users` WHERE `users_id` = ?',
  [req.query.users_id],
  function(err, results) {
    res.json(results);
  }
);
});

app.get('/getByUsername', function (req, res) {
  connection.query(
    'SELECT * FROM `Users` WHERE `users_username` = ?',
    [req.query.users_username],
    function(err, results) {
      res.json(results);
    }
  );
});

app.get('/addUser', function (req, res) {
connection.query(
  "INSERT INTO `users` (`users_id`, `users_first_name` , `users_last_name`, `users_username` , `users_password`, `users_email`, `users_birthdate`, `users_adress`, `users_state`, `users_city`, `users_active`) VALUES (NULL, ?, ?, ?, ?, ? , ?, ?, ?, ?, 0) ",
  [ req.query.users_first_name, 
    req.query.users_last_name,
    req.query.users_username,
    req.query.users_password,
    req.query.users_email,
    req.query.users_birthdate,
    req.query.users_adress,
    req.query.users_state,
    req.query.users_city,
    req.query.users_active
  ],
  function(err, results) {
    
    if (err)
     res.send(err);
   else
    res.json(results);
  }
);
});
app.get('/addGroup', function (req, res) {
  connection.query(
    "INSERT INTO `groupe` (`group_id`, `nom` , `description`, `creator_id`) VALUES (NULL, ?, ?, ?) ",
    [ req.query.nom, 
      req.query.description,
      req.query.creator_id,
    ],
    function(err, results) {
      
      if (err)
       res.send(err);
     else
      res.json(results);
    }
  );
  });
 
app.listen(3000)