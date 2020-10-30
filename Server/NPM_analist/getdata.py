import random
import time
from selenium import webdriver
from bs4 import BeautifulSoup
from datetime import datetime, timedelta
import pandas as pd
import requests
headers = {
   'user-agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.83 Safari/537.36 Edg/85.0.564.41'
   }
restaurant_name = "屋馬2" #6207評論 #存擋用
url_prefix = "https://www.google.com/async/reviewSort?vet=12ahUKEwiL1Zegx9rsAhXiyIsBHbdnBUcQxyx6BAgBECQ..i&ved=2ahUKEwiL1Zegx9rsAhXiyIsBHbdnBUcQjit6BQgBEIMB&rlst=f&rlz=1C1CHBF_zh-TWTW910TW910&tbs=lrf:!1m4!1u3!2m2!3m1!1e1!2m1!1e3!3sIAE,lf:1,lf_ui:4&yv=3&async=feature_id:0x346915e562d64d3b%3A0x221ad56de53b5cb7,review_source:All%20reviews,sort_by:"
#建立author, grade, comment來存放資料
author =[]
grade = []
comment = []
sorting_method = "newestFirst,"  #排序方式用最新


for i in range(0,366):  #由上圖，判斷range上限，控制在小於等於 <= [(最大評論數/10)-1]
    start_index_value = i*10 #開始評論序
    next_page_token_value = start_index_value +10 #下一頁評論序
#把完整url組裝起來
    url =  url_prefix + sorting_method + "start_index:" + str(start_index_value) + ",is_owner:false,filter_text:,associated_topic:,next_page_token:" + "CgIICg"  + ",_pms:s,_fmt:pc"
             
# 發送get請求
    sleep_time=random.uniform(0,2)
    print(f"先停留{sleep_time}秒...")
    time.sleep(sleep_time)
    text = requests.get(url,headers=headers).text
    soup = BeautifulSoup(text,'lxml')
    
    for s in soup.find_all(class_='jxjCjc'):
        
        #先過濾評論長度不為空：
            if s.find(class_="Jtu6Td").text != "":
            #print(s.find(class_="Jtu6Td").text)
                comment.append(s.find(class_="Jtu6Td").text)
                author.append(s.find(class_="TSUbDb").text)
                #print(author)
                grade.append(s.find(class_='Fam1ne')['aria-label'].split("：")[1].split(" ")[0])
            #print(grade)
    print(f"已抓取完第{start_index_value}到{next_page_token_value}項目..")
                                        
print(f"已抓取完畢..")
#整體成pd
google_comment_df = pd.DataFrame({
    "評論者":author,
    "評等":grade,
    "評語":comment,    
    })

google_comment_df.drop_duplicates(subset=["評語"])
google_comment_df.to_csv(f"./google_{restaurant_name}_comment.csv",encoding='utf-8-sig')