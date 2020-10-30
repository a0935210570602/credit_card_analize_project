import classLibrary.ConnectionMongoLibrary as cml 
from  classLibrary.CreditDataClass import CreditData
import sys
import json 

# converting string to json 
dataString = sys.argv[1]
jsonString = ""
#包裝成json.loads()的input格式
json_parser_dict = { '{' :"{\"",
                     '}' :"\"}", 
                     ':' :"\" : \"",
                     ',' :"\", \""  }
def get(letter):
      if(letter in json_parser_dict.keys()):
            print(json_parser_dict[letter])
            return json_parser_dict[letter]
      else:
            return letter
for letter in dataString:
      jsonString += get(letter)
json_object = json.loads(jsonString)
# print(json_object['creditcard_name'])

#連接伺服器
mongoServer = cml.connectDatabaseServer()
database = cml.connectDatabase(mongoServer, "creditcard")
arr = cml.connectCollection(database, "comment")

# for x in arr.find():
#   print(x["comment"])
insertData = {"name" : json_object['creditcard_name'], "comment": json_object['comment'] }
if arr.count_documents( {"comment": json_object['comment']} ) != 0 :
      print(418)
else:
      try:
            arr.insert_one(insertData)
            print(200)
      except Exception as e:
            print(419)