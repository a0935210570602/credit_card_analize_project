<?php
    header("Content-Type: application/json; charset=UTF-8");
    header("Access-Control-Allow-Methods: POST");
    header("Access-Control-Max-Age: 3600");
    header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
    header('Access-Control-Allow-Origin: http://localhost:8080');
    header('Access-Control-Allow-Credentials: true');

    // $json = file_get_contents('php://input');
    // $data = json_decode($json);
    // $request_code = $data->request_code;
    $request_code = 202;
    // $json_encode = json_encode($data);
    $json_encode = "{creditcard_name:001,comment:yourmother,request_code:202}";
    // 200 資料庫更新請求
    // 201 分析權重，信用卡推薦
    // 202 評論database update
    switch ($request_code){
        case 200:
            system("python check_update.py");
            break;  

        case 201:
            system("python ./creditcard_analyst/creditcard_analist_main.py");
            break;

        case 202:
            $tmp = exec("python db_use_upload_comment.py $json_encode");
            echo $tmp;

            break;

        default:
            echo 404;  //Service not found
            break;
    }
?>