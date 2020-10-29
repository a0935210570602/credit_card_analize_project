import classLibrary.ConnectionMongoLibrary as cml 
from  classLibrary.CreditDataClass import CreditData
import sys
import json 

# converting string to json 
dataString = sys.argv[1]
jsonString = ""
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
print(json_object['creditcard_name'])

# print(n)
# json_object = json.loads("{creditcard_name:001,comment:your mother,request_code:202}") 
# print(json_object["comment"])
# print(type(sys.argv[1]))
# comment = "fuck fuck fuck"
# name = "001"
# mongoServer = cml.connectDatabaseServer()
# database = cml.connectDatabase(mongoServer, "creditcard")
# arr = cml.connectCollection(database, "comment")

# # for x in arr.find():
# #   print(x["comment"])
# insertData = {"name" :name, "comment":comment }
# if arr.count_documents( {"comment":comment} ) != 0 :
#       print(418)
# else:
#       try:
#             arr.insert_one(insertData)
#             print(200)
#       except Exception as e:
#             print("insert data to comment fail")