from selenium import webdriver
from selenium.webdriver.chrome.options import Options

import urllib.request as req
import requests
import bs4
import sys 

import os
import time

from Get_inf import get_inf1
from Write_to_excel import *
from Get_num_of_card import get_num_of_card

#1: 150 (132)
#2: 60 (41)
#3: 45 (25) 
#4: 45 (25) 
#5: 55 (35)
#6: 40 (20)
#7: 123 (103)
#8: 66 (46)
#9: 32 (12)
#10: 50 (31)
#11: 35 (15)

# path: chromedriver.exe 的位址
path = 'C:/Users/USER/python_venv/my_venv/py_projeect/project_creditcard/test_ Crawl information/chromedriver.exe'
# usr: 網址
# N: 滾輪下滑次數
# folder_path: 圖片存放位置
# file_name:檔案名稱(xlsx)
def get_image_url(usr,N,folder_path,file_name,mode=0,path = 'C:/Users/USER/python_venv/my_venv/py_projeect/project_creditcard/test_ Crawl information/chromedriver.exe'):

    options = Options()
    options.add_argument("--disable-notifications")

    chrome = webdriver.Chrome(path, chrome_options=options)
    chrome.get(usr)

    #利用class_name 來定位所要抓取的部分
    #在該網頁中，results-list-view，是放置所有信用卡資訊的 div 的 class name
    container = chrome.find_element_by_class_name("results-list-view")

    #最大化視窗
    chrome.maximize_window()

    print(container.size)

    for n in range(N):
        l = 200
        chrome.execute_script('window.scrollBy(0,'+str(l)+')')
        time.sleep(0.8)

    print(container.size)

    data = chrome.page_source

    root=bs4.BeautifulSoup(data, "html.parser")
    picture = root.find_all("img")

    card_name = root.find_all("h3")
    card_name = [e.text for e in card_name] 
    card_name.pop(0)
    for i in range(7):
        card_name.pop(-1)

    # print(card_name)
    # print(len(card_name))
    # print(picture)

    # folder_path ='./photo_1/11/'
    photolimit = len(picture)

    if (os.path.exists(folder_path) == False): #判斷資料夾是否存在

        os.makedirs(folder_path) #Create folder

    card_image_temp = []

    for index , item in enumerate (picture):

        if (item and index < photolimit ):
            try:
                html = requests.get(item.get('src')) # use 'get' to get photo link path , requests = send request
                
                print(str(item.get('src')))

                if mode == 7 :
                    if (index + 1)%2 == 0 or (index + 1) == 13 and (index + 1) != 12 : #7
                        continue
                    else:
                        img_name = folder_path + str(index + 1) + '.png'
                        card_image_temp.append(str(item.get('src')))

                    # img_name = folder_path + str(item.get('alt')) + '.png'
                    img_name = folder_path + str(index + 1) + '.png'

                else:
                    if (index + 1)%2 == 0 :
                        continue
                    else:
                        img_name = folder_path + str(index + 1) + '.png'
                        card_image_temp.append(str(item.get('src')))

                    # img_name = folder_path + str(item.get('alt')) + '.png'
                    img_name = folder_path + str(index + 1) + '.png'

            except:
                continue
            
            # 'wb' 表示已二進制的方式寫入並創建文件，若該文件已存在，會覆寫
            with open(img_name,'wb') as file: #以byte的形式將圖片數據寫入

                file.write(html.content)

                file.flush()

            file.close() #close file

            print('第 %d 張' % (index + 1))

            time.sleep(1)

    card_image_temp.pop(0)
    for i in range(4):
        card_image_temp.pop(-1)

    print(card_image_temp)
    print("ok")

    write_to_excel_1(card_image_temp,str(file_name),'card_url',mode=0,ind = card_name)

usr1 = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E7%8F%BE%E9%87%91%E5%9B%9E%E9%A5%8B' 
N1 = get_num_of_card(usr1) + 20
folder_path1 = './image/1/'
get_image_url(usr1,N1,folder_path1,'card_usl_1.xlsx')

usr2 = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E5%93%A9%E7%A8%8B%E5%9B%9E%E9%A5%8B%E5%84%AA%E6%83%A0' 
N2 = get_num_of_card(usr2) + 20
folder_path2 = './image/2/'
get_image_url(usr2,N2,folder_path2,'card_usl_2.xlsx')

usr3 = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E5%8A%A0%E6%B2%B9%E5%8D%A1%E5%84%AA%E6%83%A0' 
N3 = get_num_of_card(usr3) + 20
folder_path3 = './image/3/'
get_image_url(usr3,N3,folder_path3,'card_usl_3.xlsx')

usr4 = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E9%9B%BB%E5%BD%B1%E5%84%AA%E6%83%A0' 
N4 = get_num_of_card(usr4) + 20
folder_path4 = './image/4/'
get_image_url(usr4,N4,folder_path4,'card_usl_4.xlsx')

usr5 = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E5%88%86%E6%9C%9F%E9%9B%B6%E5%88%A9%E7%8E%87%E5%84%AA%E6%83%A0' 
N5 = get_num_of_card(usr5) + 20
folder_path5 = './image/5/'
get_image_url(usr5,N5,folder_path5,'card_usl_5.xlsx')

usr6 = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E7%B6%B2%E8%B7%AF%E8%B3%BC%E7%89%A9' 
N6 = get_num_of_card(usr6) + 20
folder_path6 = './image/6/'
get_image_url(usr6,N6,folder_path6,'card_usl_6.xlsx')

usr7 = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E4%BF%A1%E7%94%A8%E5%8D%A1%E9%A6%96%E5%88%B7%E7%A6%AE' 
N7 = get_num_of_card(usr7) + 20
folder_path7 = './image/7/'
get_image_url(usr7,N7,folder_path7,'card_usl_7.xlsx')

usr8 = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E7%B9%B3%E4%BF%9D%E8%B2%BB%E5%84%AA%E6%83%A0' 
N8 = get_num_of_card(usr8) + 20
folder_path8 = './image/8/'
get_image_url(usr8,N8,folder_path8,'card_usl_8.xlsx')

usr9 = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E4%BA%9E%E6%B4%B2%E8%90%AC%E9%87%8C%E9%80%9A' 
N9 = get_num_of_card(usr9) + 20
folder_path9 = './image/9/'
get_image_url(usr9,N9,folder_path9,'card_usl_9.xlsx')

usr10 = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E7%B9%B3%E7%A8%85%E5%84%AA%E6%83%A0' 
N10 = get_num_of_card(usr10) + 20
folder_path10 = './image/10/'
get_image_url(usr10,N10,folder_path10,'card_usl_10.xlsx')

usr11 = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E7%B4%85%E5%88%A9%E9%BB%9E%E6%95%B8' 
N11 = get_num_of_card(usr11) + 20
folder_path11 = './image/11/'
get_image_url(usr11,N11,folder_path11,'card_usl_11.xlsx')

