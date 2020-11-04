
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
import time
from Get_num_of_card import get_num_of_card
from Get_inf import *
import pandas as pd
import numpy as np
from Write_to_excel import write_to_excel

#現金回饋
def crash0():
    print("現金回饋")
    options = Options()
    options.add_argument("--disable-notifications")

    usr = "https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E7%8F%BE%E9%87%91%E5%9B%9E%E9%A5%8B"
    chrome = webdriver.Chrome('C:/Users/USER/OneDrive/桌面/信用卡推薦系統_爬蟲程式/chromedriver.exe', chrome_options=options)
    chrome.get(usr)

    #利用class_name 來定位所要抓取的部分
    #在該網頁中，results-list-view，是放置所有信用卡資訊的 div 的 class name
    container = chrome.find_element_by_class_name("results-list-view")

    # 因為每次加載一批新的隱藏資訊，都是以10個為一組
    num_card = get_num_of_card(usr)
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
    inf_all = get_inf_all(chrome.page_source)
    titles = ["銀行","信用卡","年費","國外現金回饋","國內現金回饋"]
    print(titles)
    print()

    #因為該部分有問題，且是沒有規律的，所以，拿出來個別處理
    inf_all[115][1] = "昇利卡"
    inf_all[125][1] = "亞洲萬里通聯名白金卡"

    #印出結果
    print(inf_all)

    chrome.close()

    return inf_all

#哩程
def crash1():
    print("哩程")
    usr = "https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E5%93%A9%E7%A8%8B%E5%9B%9E%E9%A5%8B%E5%84%AA%E6%83%A0"

    options = Options()
    options.add_argument("--disable-notifications")

    chrome = webdriver.Chrome('C:/Users/USER/OneDrive/桌面/信用卡推薦系統_爬蟲程式/chromedriver.exe', chrome_options=options)
    chrome.get(usr)

    #利用class_name 來定位所要抓取的部分
    #在該網頁中，results-list-view，是放置所有信用卡資訊的 div 的 class name
    container = chrome.find_element_by_class_name("results-list-view")
    num_card = get_num_of_card(usr)
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
    data = chrome.page_source

    #i = 4,6,8,28 有問題
    inf_all = get_inf_all_1(data)
    inf_all[4][1] = '亞洲萬里通聯名世界卡'
    inf_all[6][1] = '亞洲萬里通聯名世界卡'
    inf_all[8][1] = '亞洲萬里通聯名世界卡'
    inf_all[28][1] = '亞洲萬里通聯名世界卡'

    titles = ["銀行","信用卡","年費","國外哩程回饋","國內哩程回饋"]
    print(titles)
    print(inf_all)

    chrome.close()

    return inf_all

#加油卡
def crash2():
    print("加油卡")
    usr = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E5%8A%A0%E6%B2%B9%E5%8D%A1%E5%84%AA%E6%83%A0'

    options = Options()
    options.add_argument("--disable-notifications")

    chrome = webdriver.Chrome('C:/Users/USER/OneDrive/桌面/信用卡推薦系統_爬蟲程式/chromedriver.exe', chrome_options=options)
    chrome.get(usr)

    #利用class_name 來定位所要抓取的部分
    #在該網頁中，results-list-view，是放置所有信用卡資訊的 div 的 class name
    container = chrome.find_element_by_class_name("results-list-view")
    num_card = get_num_of_card(usr)
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
    data = chrome.page_source

    inf_all = get_inf_all_2(data)
    titles = ["銀行","信用卡","年費","加油現金回饋","加油優惠"]
    print(titles)
    print(inf_all)

    chrome.close()

    return inf_all

#電影優惠卡
def crash3():
    print("電影優惠卡")
    usr = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E9%9B%BB%E5%BD%B1%E5%84%AA%E6%83%A0'

    options = Options()
    options.add_argument("--disable-notifications")

    chrome = webdriver.Chrome('C:/Users/USER/OneDrive/桌面/信用卡推薦系統_爬蟲程式/chromedriver.exe', chrome_options=options)
    chrome.get(usr)

    #利用class_name 來定位所要抓取的部分
    #在該網頁中，results-list-view，是放置所有信用卡資訊的 div 的 class name
    container = chrome.find_element_by_class_name("results-list-view")
    num_card = get_num_of_card(usr)
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
    data = chrome.page_source

    inf_all = get_inf_all_3(data)
    titles = ["銀行","信用卡","年費","周末電影折扣","平日電影折扣"]
    print(titles)
    print(inf_all)

    chrome.close()

    return inf_all

#分期零利率優惠
def crash4():
    print("分期零利率優惠")
    usr = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E5%88%86%E6%9C%9F%E9%9B%B6%E5%88%A9%E7%8E%87%E5%84%AA%E6%83%A0'

    options = Options()
    options.add_argument("--disable-notifications")

    chrome = webdriver.Chrome('C:/Users/USER/OneDrive/桌面/信用卡推薦系統_爬蟲程式/chromedriver.exe', chrome_options=options)
    chrome.get(usr)

    #利用class_name 來定位所要抓取的部分
    #在該網頁中，results-list-view，是放置所有信用卡資訊的 div 的 class name
    container = chrome.find_element_by_class_name("results-list-view")
    num_card = get_num_of_card(usr)
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
    data = chrome.page_source

    inf_all = get_inf_all_4(data)
    titles = ["銀行","信用卡","年費","最高分期期數","最低分期金額限制"]
    print(titles)
    print(inf_all)

    chrome.close()

    return inf_all

#網購
def crash5():
    print("網購")
    usr = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E7%B6%B2%E8%B7%AF%E8%B3%BC%E7%89%A9'

    options = Options()
    options.add_argument("--disable-notifications")

    chrome = webdriver.Chrome('C:/Users/USER/OneDrive/桌面/信用卡推薦系統_爬蟲程式/chromedriver.exe', chrome_options=options)
    chrome.get(usr)

    #利用class_name 來定位所要抓取的部分
    #在該網頁中，results-list-view，是放置所有信用卡資訊的 div 的 class name
    container = chrome.find_element_by_class_name("results-list-view")
    num_card = get_num_of_card(usr)
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
    data = chrome.page_source

    inf_all = get_inf_all_5(data)
    titles = ["銀行","信用卡","數位通路回饋上限","國內消費現金回饋","網購回饋"]
    print(titles)
    print(inf_all)

    chrome.close()

    return inf_all

#信用卡首刷禮
def crash6():
    print("信用卡首刷禮")
    usr = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E4%BF%A1%E7%94%A8%E5%8D%A1%E9%A6%96%E5%88%B7%E7%A6%AE'

    options = Options()
    options.add_argument("--disable-notifications")

    chrome = webdriver.Chrome('C:/Users/USER/OneDrive/桌面/信用卡推薦系統_爬蟲程式/chromedriver.exe', chrome_options=options)
    chrome.get(usr)

    #利用class_name 來定位所要抓取的部分
    #在該網頁中，results-list-view，是放置所有信用卡資訊的 div 的 class name
    container = chrome.find_element_by_class_name("results-list-view")
    num_card = get_num_of_card(usr)
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
    data = chrome.page_source

    inf_all = get_inf_all_6(data)
    titles = ["銀行","信用卡","首刷送行李箱","首刷哩程回饋","首刷現金回饋"]
    print(titles)
    print(inf_all)

    chrome.close()

    return inf_all

# 繳保費優惠
def crash7():
    print("繳保費優惠")
    usr = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E7%B9%B3%E4%BF%9D%E8%B2%BB%E5%84%AA%E6%83%A0'

    options = Options()
    options.add_argument("--disable-notifications")

    chrome = webdriver.Chrome('C:/Users/USER/OneDrive/桌面/信用卡推薦系統_爬蟲程式/chromedriver.exe', chrome_options=options)
    chrome.get(usr)

    #利用class_name 來定位所要抓取的部分
    #在該網頁中，results-list-view，是放置所有信用卡資訊的 div 的 class name
    container = chrome.find_element_by_class_name("results-list-view")
    num_card = get_num_of_card(usr)
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
    data = chrome.page_source

    inf_all = get_inf_all_7(data)
    titles = ["銀行","信用卡","刷保費哩程回饋","最高分期期數(0利率)","刷保費現金回饋"]
    print(titles)
    print(inf_all)

    chrome.close()

    return inf_all

# 亞洲萬里通
def crash8():
    print("亞洲萬里通")
    usr = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E4%BA%9E%E6%B4%B2%E8%90%AC%E9%87%8C%E9%80%9A'

    options = Options()
    options.add_argument("--disable-notifications")

    chrome = webdriver.Chrome('C:/Users/USER/OneDrive/桌面/信用卡推薦系統_爬蟲程式/chromedriver.exe', chrome_options=options)
    chrome.get(usr)

    #利用class_name 來定位所要抓取的部分
    #在該網頁中，results-list-view，是放置所有信用卡資訊的 div 的 class name
    container = chrome.find_element_by_class_name("results-list-view")
    num_card = get_num_of_card(usr)
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
    data = chrome.page_source

    inf_all = get_inf_all_8(data)
    titles = ["銀行","信用卡","首刷哩程回饋","國外哩程回饋","國內哩程回饋"]
    inf_all[0][1] = "亞洲萬里通聯名鈦商卡"
    inf_all[1][1] = "亞洲萬里通聯名世界卡"
    inf_all[2][1] = "亞洲萬里通聯名白金卡"
    inf_all[8][1] = "亞洲萬里通聯名里享卡"
    print(titles)
    print(inf_all)

    chrome.close()

    return inf_all

# 繳稅優惠
def crash9():
    print("繳稅優惠")
    usr = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E7%B9%B3%E7%A8%85%E5%84%AA%E6%83%A0'

    options = Options()
    options.add_argument("--disable-notifications")

    chrome = webdriver.Chrome('C:/Users/USER/OneDrive/桌面/信用卡推薦系統_爬蟲程式/chromedriver.exe', chrome_options=options)
    chrome.get(usr)

    #利用class_name 來定位所要抓取的部分
    #在該網頁中，results-list-view，是放置所有信用卡資訊的 div 的 class name
    container = chrome.find_element_by_class_name("results-list-view")
    num_card = get_num_of_card(usr)
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
    data = chrome.page_source

    inf_all = get_inf_all_9(data)
    titles = ["銀行","信用卡","最低可分期金額","最高分期期數(0利率)","最高分期期數"]
    print(titles)
    print(inf_all)

    chrome.close()

    return inf_all

# 紅利點數
def crash10():
    print("紅利點數")
    usr = 'https://www.money101.com.tw/%E4%BF%A1%E7%94%A8%E5%8D%A1/%E7%B4%85%E5%88%A9%E9%BB%9E%E6%95%B8'

    options = Options()
    options.add_argument("--disable-notifications")

    chrome = webdriver.Chrome('C:/Users/USER/OneDrive/桌面/信用卡推薦系統_爬蟲程式/chromedriver.exe', chrome_options=options)
    chrome.get(usr)

    #利用class_name 來定位所要抓取的部分
    #在該網頁中，results-list-view，是放置所有信用卡資訊的 div 的 class name
    container = chrome.find_element_by_class_name("results-list-view")
    num_card = get_num_of_card(usr)
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
    data = chrome.page_source

    inf_all = get_inf_all_10(data)
    titles = ["銀行","信用卡","紅利折抵金","紅利換哩程","最高基點倍數"]
    print(titles)
    print(inf_all)

    chrome.close()

    return inf_all

a = crash0()
b = crash1()
c = crash2()
d = crash3()
e = crash4()
f = crash5()
g = crash6()
h = crash7()
i = crash8()
j = crash9()
k = crash10()

#將所有抓到的卡片資訊輸出成excel檔
def get_crash_all():

    crash_all = a+b+c+d+e+f+g+h+i+j+k

    write_to_excel(crash_all,"crash_all.xlsx","crash_all")

# 得到不同類型的卡片的分界，並輸出成excel檔
def get_num_range():
    init = 0
    num_range = []
    num_range_temp = []
    crash_list = [a,b,c,d,e,f,g,h,i,j,k]
    for x in range(len(crash_list)):
        num_range_temp.append(init)
        num_range_temp.append(init + len(crash_list[x])-1)
        init += len(crash_list[x])
        num_range.append(num_range_temp)
        num_range_temp = []

    write_to_excel(num_range,"num_range.xlsx","num_range")

#決定該張卡片屬於哪一類
def which_class(lst):
    # 讀取excel
    df = pd.read_excel("num_range.xlsx")
    # 將其資料型態從 dataframe 變成 list
    # num_range:不同類型的卡片分界(以索引表示)
    num_range = np.array(df).tolist()

    for i in range(len(num_range)):
        if (num_range[i][1] <= lst[0]) and (lst[0] <= num_range[i][2]):
            print(i)
            return i

#依照該卡片的分類，重新建立一個新的卡片資訊串列(包含25個資訊)
# lst: 要丟入的卡片資訊(只有5個)；mode: 該卡片的分類；lst_temp: 要輸出的新卡片資訊(包含25個資訊)
def reshape(lst,mode,lst_temp = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]):
    if mode ==0:
        #現金回饋
        # lst_temp = ['','','','','','','','','','','','','','','','','','','','','','','','','']
        # lst_temp = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        # print(len(lst_temp))
        #銀行
        lst_temp[0] = lst[1]
        #信用卡
        lst_temp[1] = lst[2]
        #年費
        lst_temp[2] = lst[3]
        #國外消費現金回饋
        lst_temp[3] = lst[4]
        #國內消費現金回饋
        lst_temp[4] = lst[5]
        return lst_temp
        
    if mode ==1:
        #哩程回饋優惠
        # lst_temp = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        #銀行
        lst_temp[0] = lst[1]
        #信用卡
        lst_temp[1] = lst[2]
        #年費
        lst_temp[2] = lst[3]
        #國外哩程回饋
        lst_temp[5] = lst[4]
        #國內哩程回饋
        lst_temp[6] = lst[5]
        return lst_temp

    if mode ==2:
        #加油卡優惠
        # lst_temp = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        #銀行
        lst_temp[0] = lst[1]
        #信用卡
        lst_temp[1] = lst[2]
        #年費
        lst_temp[2] = lst[3]
        #加油現金回饋
        lst_temp[7] = lst[4]
        #加油優惠
        lst_temp[8] = lst[5]
        return lst_temp

    if mode ==3:
        #電影優惠
        # lst_temp = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        #銀行
        lst_temp[0] = lst[1]
        #信用卡
        lst_temp[1] = lst[2]
        #年費
        lst_temp[2] = lst[3]
        #周末電影折扣
        lst_temp[9] = lst[4]
        #平日電影折扣
        lst_temp[10] = lst[5]
        return lst_temp

    if mode ==4:
        #分期零利率優惠
        # lst_temp = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        #銀行
        lst_temp[0] = lst[1]
        #信用卡
        lst_temp[1] = lst[2]
        #年費
        lst_temp[2] = lst[3]
        #最高分期期數
        lst_temp[11] = lst[4]
        #最低可分期金額
        lst_temp[12] = lst[5]
        return lst_temp

    if mode ==5:
        #網路購物
        # lst_temp = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        #銀行
        lst_temp[0] = lst[1]
        #信用卡
        lst_temp[1] = lst[2]
        #回櫃上限
        lst_temp[13] = lst[3]
        #國內消費現金回饋
        lst_temp[4] = lst[4]
        #網購回饋
        lst_temp[14] = lst[5]
        return lst_temp

    if mode ==6:
        #信用卡首刷禮
        # lst_temp = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        #銀行
        lst_temp[0] = lst[1]
        #信用卡
        lst_temp[1] = lst[2]
        #首刷送行李箱
        lst_temp[15] = lst[3]
        #首刷哩程回饋
        lst_temp[16] = lst[4]
        #首刷現金回饋
        lst_temp[17] = lst[5]
        return lst_temp

    if mode ==7:
        #繳保費優惠
        # lst_temp = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        #銀行
        lst_temp[0] = lst[1]
        #信用卡
        lst_temp[1] = lst[2]
        #刷保費哩程回饋
        lst_temp[18] = lst[3]
        #最高分期期數(0利率)
        lst_temp[19] = lst[4]
        #刷保費現金回饋
        lst_temp[20] = lst[5]
        return lst_temp

    if mode ==8:
        #亞洲萬里通
        # lst_temp = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        #銀行
        lst_temp[0] = lst[1]
        #信用卡
        lst_temp[1] = lst[2]
        #首刷哩程回饋
        lst_temp[16] = lst[3]
        #國外哩程回饋
        lst_temp[5] = lst[4]
        #國內哩程回饋
        lst_temp[6] = lst[5]
        return lst_temp

    if mode ==9:
        #繳稅優惠
        # lst_temp = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        #銀行
        lst_temp[0] = lst[1]
        #信用卡
        lst_temp[1] = lst[2]
        #最低可分期金額
        lst_temp[21] = lst[3]
        #國外哩程回饋
        lst_temp[19] = lst[4]
        #國內哩程回饋
        lst_temp[11] = lst[5]
        return lst_temp

    if mode ==10:
        #紅利點數
        # lst_temp = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        #銀行
        lst_temp[0] = lst[1]
        #信用卡
        lst_temp[1] = lst[2]
        #紅利折抵金
        lst_temp[22] = lst[3]
        #紅利換哩程
        lst_temp[23] = lst[4]
        #最高基點倍數
        lst_temp[24] = lst[5]
        return lst_temp

#回傳重新分類後的結果(依照:屬於不同類別但是同一張卡片的資訊)
def reclassify():
    # crash_all.xlsx 為 main 中，所輸出的excel檔
    df = pd.read_excel("crash_all.xlsx")
    # print(df)
    # 將其資料型態從 dataframe 變成 list
    crash_all = np.array(df).tolist()
    # print(crash_all)
    # print(len(crash_all))

    # 將不同類型的同一張卡片放在一起
    crash_all_copy = [e for e in crash_all]
    same_cards = []
    x = len(crash_all_copy)
    for i in range(x):
        if i not in same_cards:
            same_cards.append(i)
        else:
            continue
        for j in range(i+1,x):
            if (crash_all_copy[i][1] == crash_all_copy[j][1] and crash_all_copy[i][2] == crash_all_copy[j][2]) and ( j not in same_cards):
                    same_cards.append(j)

        same_cards.append(' ')


    # 將不同類型的同一張卡放到同一個子字串中
    same_cards_list = []
    same_cards_temp = []
    for i in range(len(same_cards)):
        if same_cards[i] == ' ':
            same_cards_list.append(same_cards_temp)
            same_cards_temp = []
            continue
        same_cards_temp.append(same_cards[i])

    return same_cards_list

# 將整理好的卡片資訊輸出成exel檔
def result():
    #讀取excel檔
    df = pd.read_excel("crash_all.xlsx")
    # 將其資料型態從 dataframe 變成 list
    # crash_all: 所有卡片的資訊
    crash_all = np.array(df).tolist()

    same_cards = reclassify()

    result_lst = []
    for i in range(len(same_cards)):
        lst_1 = same_cards[i]
        lst_4 = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        for j in range(len(lst_1)):
            lst_2 = lst_1[j]
            lst_3 = crash_all[lst_2]
            lst_4 = reshape(lst_3,which_class(lst_3),lst_4)

        result_lst.append(lst_4)

    print(result_lst)

    write_to_excel(result_lst,"result_lst.xlsx","result_lst",mode = 1)
