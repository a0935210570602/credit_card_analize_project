from pymongo import MongoClient # for database
import xlrd #for excel
 
client = MongoClient() #connect mongo

check = input("input a value to update data base:")

if check == 'y':
    print("\nthe data has been updated\n")

    db = client.bank #access database
    posts = db.posts #collection of test
    posts.drop()

    loc = ("result_lst.xlsx")#loaction of the file
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
        'Foreign Mileage Credit(Percentage)': list[6],
        'Dosmestic Mileage Credit(Percentage)': list[7],
        'Foreign Mileage Credit(NT/mile)': list[7],
        'Dosmestic Mileage Credit(NT/mile)': list[7],
        'Refuel Cashback': list[8],
        'Refuel Discount': list[9],
        'Weekend Movie Discount': list[10],
        'Week days Movie Discount': list[11],
        'Highest Installment': list[12],
        'Lowest Installment Amount': list[13],
        'Maxium Cashback': list[14],
        'Online Shopping Feedback': list[15],
        'Churning Suitcase': list[16],
        'Churning Mileage Credit': list[17],
        'Churning Cashback': list[18],
        'Credit Card Fee Mileage Credit': list[19],
        'Highest Installment(0 Interest)': list[20],
        'Credit Card Fee Cashback': list[21],
        'Lowest Cost Qualification for Installment': list[22],
        'Credits for Cash': list[23],
        'Credits fot Mileage': list[24],
        'Credit Card Multiple Points': list[25],
        }

        result = posts.insert_one(post_data)#insert the value to database
        print('One post: {0}'.format(result.inserted_id))#print out the id

else:
    print("The data is old and poor")

#two lines below are used to find a specific data
#scotts_posts = posts.find({'Credit Card':'現金回饋PLUS卡'})
#print(scotts_posts)