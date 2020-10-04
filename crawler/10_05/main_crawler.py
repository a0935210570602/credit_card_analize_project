
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
import time

options = Options()
options.add_argument("--disable-notifications")

chrome = webdriver.Chrome('C:/Users/USER/OneDrive/桌面/crawler/10_05/chromedriver.exe', chrome_options=options)
chrome.get("https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E7%8F%BE%E9%87%91%E5%9B%9E%E9%A5%8B")

#利用class_name 來定位所要抓取的部分
#在該網頁中，results-list-view，是放置所有信用卡資訊的 div 的 class name
container = chrome.find_element_by_class_name("results-list-view")
lst_container = [e for e in container.text]
#移動到該元素(container)的頂部(true)
# chrome.execute_script("arguments[0].scrollIntoView(true);",container)

# 因為每次加載一批新的隱藏資訊，都是以10個為一組
# int(128/10) = 12 ，所以總共要加載12次
num_card = 131
for i in range(int(num_card/10)):
    #移動到該元素(container)(即目前顯示的資訊)的底部(false)
    chrome.execute_script("arguments[0].scrollIntoView(false);",container)
    
    #在終端機上顯示，以便確定網頁有在，依所要的指示操作
    print(i,": ","move to the bottom of container")
    
    #滾輪下滑1000
    #因為移至「目前已顯示資訊的最底部」還不夠，還要再用滾輪往下滑一段距離，才會加載出一批新的資訊
    chrome.execute_script("window.scrollBy(0,1000)")
    print("ok")

    #留時間給網頁載入(迴圈的)
    time.sleep(1)

time.sleep(1)


############################inf_all####################################

#利用函式 get_inf_all 輸出「篩選條件:現金回饋」 所有信用卡資訊
from Get_inf import get_inf_all
inf_all = get_inf_all(chrome.page_source)
titles = ["銀行","信用卡","年費","國外現金回饋","國內現金回饋"]
print(titles)
print()

#因為該部分有問題，且是沒有規律的，所以，拿出來個別處理
inf_all[115][1] = "昇利卡"
inf_all[125][1] = "亞洲萬里通聯名白金卡"

#印出結果
print(inf_all)
################################################################

import pandas as pd
import numpy as np
from openpyxl import load_workbook

# x = np.array(inf_all)
# print(x)

# df = pd.DataFrame(x,columns = titles)

# df.to_csv(file_name)

df = pd.DataFrame(inf_all,columns = ["銀行","信用卡","年費","國外現金回饋","國內現金回饋"])
print(df)

df.to_excel('test1.xlsx',sheet_name = 'test1')

chrome.close()
