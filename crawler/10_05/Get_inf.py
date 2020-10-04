##2.<<擷取該網頁中特定部分的資料>>

from bs4 import BeautifulSoup
from Filter_data import *

def get_inf1(data):   
    #擷取卡片資訊(1)-銀行和卡片名
    soup = BeautifulSoup(data, 'html.parser')
    
    #法二: 還不確定會不會有問題，但可以只抓需要的資料(0821)
    contents1 = soup.find_all("h3")

    #將擷取到的資訊，轉換成文字，並丟入串列中
    content1 = [e.text for e in contents1] 

    #法二-過濾不要的資訊
    content1.pop(0)
    for i in range(7):
        content1.pop(-1)
    
    lst_inf1 = [ ]
    for x in range(len(content1)):
        lst_inf1.append([get_bank_name(content1,x),get_card_name(content1,x)])

    return lst_inf1

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

def get_inf_all(data):
    lst_inf_all = [ ]
    inf1_lst = get_inf1(data)
    inf2_lst = get_inf2(data)

    for i in range(len(get_inf1(data))):
        lst_inf_all.append(inf1_lst[i] + inf2_lst[i])
        print(i)

    return lst_inf_all

