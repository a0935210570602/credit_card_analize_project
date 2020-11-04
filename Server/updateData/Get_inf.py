##2.<<擷取該網頁中特定部分的資料>>

from bs4 import BeautifulSoup
from Filter_data import *

def get_inf1(data,mode=0):   
    #擷取卡片資訊(1)-銀行和卡片名
    soup = BeautifulSoup(data, 'html.parser')
    contents1 = soup.find_all("h3")
    #將擷取到的資訊，轉換成文字，並丟入串列中
    content1 = [e.text for e in contents1] 

    #過濾不要的資訊
    if mode == 0:
        content1.pop(0)
        for i in range(7):
            content1.pop(-1)
        lst_inf1 = [ ]
        for x in range(len(content1)):
            lst_inf1.append([get_bank_name(content1,x),get_card_name(content1,x)])
        return lst_inf1

    elif mode == 1: #(9)
        content1.pop(0)
        lst_inf1 = [ ]
        for x in range(len(content1)):
            lst_inf1.append([get_bank_name(content1,x),get_card_name(content1,x)])
        return lst_inf1

############################## get_inf2 ##############################################

# 現金回饋(0)
def get_inf2(data):
    #擷取卡片資訊(2)-優惠
    soup = BeautifulSoup(data, 'html.parser')
    contents2 = soup.find_all('div',class_="compare-element-column")
    # 將擷取到的資訊，轉換成文字，並丟入串列中
    content2 = [e.text for e in contents2]

    lst_inf2 = [ ]
    for x in range(int(len(content2)/3)):
        lst_inf2.append([get_annual_fee(content2,x),get_crashback1(content2,x),
        get_crashback2(content2,x)]) 
    return lst_inf2
#哩程的(1)
def get_inf2_1(data):
    #擷取卡片資訊(2)-優惠
    soup = BeautifulSoup(data, 'html.parser')
    contents2 = soup.find_all('div',class_="compare-element-column")

    # 將擷取到的資訊，轉換成文字，並丟入串列中
    content2 = [e.text for e in contents2]

    lst_inf2 = [ ]
    i = int(len(content2)/3)
    for x in range(i):
        lst_inf2.append([get_annual_fee(content2,x),get_crashback1_1(content2,x),
        get_crashback2_1(content2,x)]) 
    return lst_inf2
#加油的(2)
def get_inf2_2(data):
    #擷取卡片資訊(2)-優惠
    soup = BeautifulSoup(data, 'html.parser')
    contents2 = soup.find_all('div',class_="compare-element-column")

    # 將擷取到的資訊，轉換成文字，並丟入串列中
    content2 = [e.text for e in contents2]

    lst_inf2 = [ ]
    i = int(len(content2)/3)
    for x in range(i):
        lst_inf2.append([get_annual_fee(content2,x),get_crashback1_2(content2,x),
        get_crashback2_1(content2,x)]) 
    return lst_inf2
#電影的(3)
def get_inf2_3(data):
    #擷取卡片資訊(2)-優惠
    soup = BeautifulSoup(data, 'html.parser')
    contents2 = soup.find_all('div',class_="compare-element-column")

    # 將擷取到的資訊，轉換成文字，並丟入串列中
    content2 = [e.text for e in contents2]

    lst_inf2 = [ ]
    i = int(len(content2)/3)
    for x in range(i):
        lst_inf2.append([get_annual_fee(content2,x),get_crashback1_3(content2,x),
        get_crashback2_3(content2,x)]) 
    return lst_inf2
# 分期零利率優惠(4)
def get_inf2_4(data):
    #擷取卡片資訊(2)-優惠
    soup = BeautifulSoup(data, 'html.parser')
    contents2 = soup.find_all('div',class_="compare-element-column")

    # 將擷取到的資訊，轉換成文字，並丟入串列中
    content2 = [e.text for e in contents2]

    lst_inf2 = [ ]
    i = int(len(content2)/3)
    for x in range(i):
        lst_inf2.append([get_annual_fee(content2,x),get_crashback1_4(content2,x),
        get_crashback2_4(content2,x)]) 
    return lst_inf2
# 網購(5)
def get_inf2_5(data):
    #擷取卡片資訊(2)-優惠
    soup = BeautifulSoup(data, 'html.parser')
    contents2 = soup.find_all('div',class_="compare-element-column")

    # 將擷取到的資訊，轉換成文字，並丟入串列中
    content2 = [e.text for e in contents2]

    lst_inf2 = [ ]
    i = int(len(content2)/3)
    for x in range(i):
        lst_inf2.append([get_crashback0_5(content2,x),get_crashback1_5(content2,x),
        get_crashback2_5(content2,x)]) 
    return lst_inf2
# 信用卡首刷禮(6)
def get_inf2_6(data):
    #擷取卡片資訊(2)-優惠
    soup = BeautifulSoup(data, 'html.parser')
    contents2 = soup.find_all('div',class_="compare-element-column")

    # 將擷取到的資訊，轉換成文字，並丟入串列中
    content2 = [e.text for e in contents2]

    lst_inf2 = [ ]
    i = int(len(content2)/3)
    for x in range(i):
        lst_inf2.append([get_crashback0_6(content2,x),get_crashback1_6(content2,x),
        get_crashback2_6(content2,x)]) 
    return lst_inf2
# 繳保費優惠(7)
def get_inf2_7(data):
    #擷取卡片資訊(2)-優惠
    soup = BeautifulSoup(data, 'html.parser')
    contents2 = soup.find_all('div',class_="compare-element-column")

    # 將擷取到的資訊，轉換成文字，並丟入串列中
    content2 = [e.text for e in contents2]

    lst_inf2 = [ ]
    i = int(len(content2)/3)
    for x in range(i):
        lst_inf2.append([get_crashback0_7(content2,x),get_crashback1_7(content2,x),
        get_crashback2_7(content2,x)]) 
    return lst_inf2
# 亞洲萬里通(8)
def get_inf2_8(data):
    #擷取卡片資訊(2)-優惠
    soup = BeautifulSoup(data, 'html.parser')
    contents2 = soup.find_all('div',class_="compare-element-column")

    # 將擷取到的資訊，轉換成文字，並丟入串列中
    content2 = [e.text for e in contents2]

    lst_inf2 = [ ]
    i = int(len(content2)/3)
    for x in range(i):
        lst_inf2.append([get_crashback0_8(content2,x),get_crashback1_8(content2,x),
        get_crashback2_8(content2,x)]) 
    return lst_inf2
# 繳稅優惠(9)
def get_inf2_9(data):
    #擷取卡片資訊(2)-優惠
    soup = BeautifulSoup(data, 'html.parser')
    contents2 = soup.find_all('div',class_="compare-element-column")

    # 將擷取到的資訊，轉換成文字，並丟入串列中
    content2 = [e.text for e in contents2]

    lst_inf2 = [ ]
    i = int(len(content2)/3)
    for x in range(i):
        lst_inf2.append([get_crashback0_9(content2,x),get_crashback1_9(content2,x),
        get_crashback2_9(content2,x)]) 
    return lst_inf2
# 紅利點數(10)
def get_inf2_10(data):
    #擷取卡片資訊(2)-優惠
    soup = BeautifulSoup(data, 'html.parser')
    contents2 = soup.find_all('div',class_="compare-element-column")

    # 將擷取到的資訊，轉換成文字，並丟入串列中
    content2 = [e.text for e in contents2]

    lst_inf2 = [ ]
    i = int(len(content2)/3)
    for x in range(i):
        lst_inf2.append([get_crashback0_10(content2,x),get_crashback1_10(content2,x),
        get_crashback2_10(content2,x)]) 
    return lst_inf2

############################## get_inf_all ##############################################

# 現金回饋(0)
def get_inf_all(data):
    lst_inf_all = [ ]
    inf1_lst = get_inf1(data)
    inf2_lst = get_inf2(data)
    for i in range(len(get_inf1(data))):
        lst_inf_all.append(inf1_lst[i] + inf2_lst[i])
        print(i)
    return lst_inf_all
# 哩程的(1)
def get_inf_all_1(data):
    lst_inf_all = [ ]
    inf1_lst = get_inf1(data)
    inf2_lst = get_inf2_1(data)
    i = len(get_inf1(data))
    for i in range(i):
        lst_inf_all.append(inf1_lst[i] + inf2_lst[i])
        print(i)
    return lst_inf_all
# 加油的(2)
def get_inf_all_2(data):
    lst_inf_all = [ ]
    inf1_lst = get_inf1(data) 
    inf2_lst = get_inf2_2(data)
    i = len(get_inf1(data))
    for i in range(i):
        lst_inf_all.append(inf1_lst[i] + inf2_lst[i])
        print(i)
    return lst_inf_all
# 電影的(3)
def get_inf_all_3(data):
    lst_inf_all = [ ]
    inf1_lst = get_inf1(data) 
    inf2_lst = get_inf2_3(data)
    i = len(get_inf1(data))
    for i in range(i):
        lst_inf_all.append(inf1_lst[i] + inf2_lst[i])
        print(i)
    return lst_inf_all
# 分期零利率優惠(4)
def get_inf_all_4(data):
    lst_inf_all = [ ]
    inf1_lst = get_inf1(data) 
    inf2_lst = get_inf2_4(data)
    i = len(get_inf1(data))
    for i in range(i):
        lst_inf_all.append(inf1_lst[i] + inf2_lst[i])
        print(i)
    return lst_inf_all
# 網購(5)
def get_inf_all_5(data):
    lst_inf_all = [ ]
    inf1_lst = get_inf1(data) 
    inf2_lst = get_inf2_5(data)
    i = len(get_inf1(data))
    for i in range(i):
        lst_inf_all.append(inf1_lst[i] + inf2_lst[i])
        print(i)
    return lst_inf_all
# 信用卡首刷禮(6)
def get_inf_all_6(data):
    lst_inf_all = [ ]
    inf1_lst = get_inf1(data) 
    inf2_lst = get_inf2_6(data)
    i = len(get_inf1(data))
    for i in range(i):
        lst_inf_all.append(inf1_lst[i] + inf2_lst[i])
        print(i)
    return lst_inf_all
# 繳保費優惠(7)
def get_inf_all_7(data):
    lst_inf_all = [ ]
    inf1_lst = get_inf1(data) 
    inf2_lst = get_inf2_7(data)
    i = len(get_inf1(data))
    for i in range(i):
        lst_inf_all.append(inf1_lst[i] + inf2_lst[i])
        print(i)
    return lst_inf_all
# 亞洲萬里通(8)
def get_inf_all_8(data):
    lst_inf_all = [ ]
    inf1_lst = get_inf1(data) 
    inf2_lst = get_inf2_8(data)
    i = len(get_inf1(data))
    for i in range(i):
        lst_inf_all.append(inf1_lst[i] + inf2_lst[i])
        print(i)
    return lst_inf_all
# 繳稅優惠(9)
def get_inf_all_9(data):
    lst_inf_all = [ ]
    inf1_lst = get_inf1(data) 
    inf2_lst = get_inf2_9(data)
    i = len(get_inf1(data))
    for i in range(i):
        lst_inf_all.append(inf1_lst[i] + inf2_lst[i])
        print(i)
    return lst_inf_all
# 紅利點數(10)
def get_inf_all_10(data):
    lst_inf_all = [ ]
    inf1_lst = get_inf1(data) 
    inf2_lst = get_inf2_10(data)
    i = len(get_inf1(data))
    for i in range(i):
        lst_inf_all.append(inf1_lst[i] + inf2_lst[i])
        print(i)
    return lst_inf_all