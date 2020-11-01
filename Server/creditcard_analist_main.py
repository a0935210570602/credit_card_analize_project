import classLibrary.ConnectionMongoLibrary as cml 
from  classLibrary.CreditDataClass import CreditData

weight = {"a":1,"b":2,"c":6,
            "d":1,"e":2,"f":6,"g":8}

mongoServer = cml.connectDatabaseServer()
database = cml.connectDatabase(mongoServer, "creditcard")
arr = cml.connectCollection(database, "card")

cre = CreditData(arr.find())
cre.createData()
cre.recommendation(weight)
result = cre.getResultInformation(3)
print(result)