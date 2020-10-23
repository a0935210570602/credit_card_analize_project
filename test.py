from pymongo import MongoClient # for database
import xlrd #for excel
 
client = MongoClient() #connect mongo
db = client.test #access database
posts = db.posts #collection of test

loc = ("credit_card_sample.xlsx")#loaction of the file
wb = xlrd.open_workbook(loc)#open file
sheet = wb.sheet_by_index(0)#???? 
 
sheet.cell_value(0, 0)#?????
 
for i in range(sheet.nrows):

    if i == 0:#skip the first row
        continue
    
    list = sheet.row_values(i)
    print(list)#check every row value
    post_data = {
    'Name of the Bank': list[1],
    'Credit Card': list[2],
    'Anual Fee': list[3],
    'Foreign Cashback': list[4],
    'Dosmestic Cashback': list[5],
    }

    result = posts.insert_one(post_data)#insert the value to database
    print('One post: {0}'.format(result.inserted_id))#print out the id


#two lines below are used to find a specific data
#scotts_posts = posts.find({'Credit Card':'現金回饋PLUS卡'})
#print(scotts_posts)