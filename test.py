from pymongo import MongoClient

import xlrd
 
client = MongoClient()
#connect mongo
db = client.test
#access database
posts = db.posts
#????

loc = ("credit_card_sample.xlsx")
 
wb = xlrd.open_workbook(loc)
sheet = wb.sheet_by_index(0)
 
sheet.cell_value(0, 0)
 
for i in range(sheet.nrows):
    if i == 0:
        continue
    
    list = sheet.row_values(i)
    print(list[1])

    post_data = {
    'Name of the Bank': list[1],
    'Credit Card': list[2],
    'Anual Fee': list[3],
    'Foreign Cashback': list[4],
    'Dosmestic Cashback': list[5],
    }

    result = posts.insert_one(post_data)#??
    print('One post: {0}'.format(result.inserted_id))#???
