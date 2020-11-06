import pandas as pd
import numpy as np
from Write_to_excel import write_to_excel_1


def result_url(result_lst,card_url_x):
    # card_url_x :檔案名稱(xlsx檔)
    df = pd.read_excel(card_url_x)
    url_list = np.array(df).tolist()
    # print("url_list",url_list) #############

    for j in range(len(result_lst)):
        for i in range(len(url_list)):
            # print(result_lst[j][1],result_lst[j][2])

            url_list_1 = url_list[i][0].split(" ")[0]
            y = url_list[i][0].index(" ")
            url_list_2 = url_list[i][0][y+1:]
            url_list_3 = url_list_1 + " " + url_list_2


            name_1 = result_lst[j][1]
            name_2 = result_lst[j][2]
            name = name_1 + " " + name_2
            # print(url_list[i][0])
            # print(name)
            # print(url_list[i][1])
            # print(len(result_lst[j]))
            if name_1 == url_list_1 and name_2 == url_list_2 and len(result_lst[j]) < 27:
                # print(url_list[i][1])
                print(url_list[i][0])
                print(name)
                result_lst[j].append(url_list[i][1])
    return result_lst

def result_1():
    #讀取excel檔
    df = pd.read_excel("result_lst.xlsx")
    # 將其資料型態從 dataframe 變成 list
    # crash_all: 所有卡片的資訊
    result_lst = np.array(df).tolist()
    print(result_lst)

    result_lst = result_url(result_lst,"card_url_1.xlsx")
    result_lst = result_url(result_lst,"card_url_2.xlsx")
    result_lst = result_url(result_lst,"card_url_3.xlsx")
    result_lst = result_url(result_lst,"card_url_4.xlsx")
    result_lst = result_url(result_lst,"card_url_5.xlsx")
    result_lst = result_url(result_lst,"card_url_6.xlsx")
    result_lst = result_url(result_lst,"card_url_7.xlsx")
    result_lst = result_url(result_lst,"card_url_8.xlsx")
    result_lst = result_url(result_lst,"card_url_9.xlsx")
    result_lst = result_url(result_lst,"card_url_10.xlsx")
    result_lst = result_url(result_lst,"card_url_11.xlsx")

    for k in range(len(result_lst)):
        result_lst[k].pop(0)

    print(result_lst)

    write_to_excel_1(result_lst,"result_url_2.xlsx","result_url",mode = 1)

result_1()