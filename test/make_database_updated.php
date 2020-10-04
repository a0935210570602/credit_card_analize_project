<?php
    header("Content-Type: application/json; charset=UTF-8");
    header("Access-Control-Allow-Methods : POST");
    header("Access-Contro1-Max-Age : 3600");
    header("Access-Contro1-Allow-Headers : Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
    header('Access-Control-Allow-Origin: http://localhost:80');
    header('Access-Control-Allow-Credentials: true');

    // echo("see");
    system("python check_page_is_update.py");
?>