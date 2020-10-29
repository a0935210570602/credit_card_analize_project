import pymongo

def connectDatabaseServer():
    try:
        return pymongo.MongoClient("mongodb://localhost:27017/")
    except Exception as e:
        print("datanase server connect error") 

def connectDatabase(mongoServer, databaseName):
    if databaseName in mongoServer.list_database_names():
        return mongoServer[databaseName]
    else:
        raise Exception("Sorry," + databaseName + " database can't not find")

def connectCollection(database, collectionName):
    if collectionName in database.list_collection_names():
        return database[collectionName]
    else:
        raise Exception("Sorry," + collectionName + " collection can't not find")