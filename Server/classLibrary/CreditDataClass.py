class CreditData():
    def __init__(self, datalist):
        self.datalist = datalist
        self.resultlist = []
        self.result = []
        self.flag = list(range(0,self.datalist.count()))
        for count in range (0,self.datalist.count()):
            self.resultlist.append({})
            for key in self.datalist[0]:
                self.resultlist[count][key] = self.datalist[count][key]

    def recommendation(self,weight):
        self.card_comperation = []
        for count in range (0,len(self.resultlist)):
            sum = 0
            for key in weight:
                sum += weight[key] * self.datalist[count][key]
            self.card_comperation.append(sum)

    def getResultInformation(self, number):
        for i in range (0,len(self.resultlist)-1):
            for j in range (i+1, len(self.resultlist)):
                if self.card_comperation[j] > self.card_comperation[i]:
                    self.card_comperation[j], self.card_comperation[i] = self.card_comperation[i], self.card_comperation[j]
                    self.flag[j],self.flag[i] = self.flag[i],self.flag[j]
        for i in range(0, number):
            self.result.append(self.datalist[self.flag[i]])
        return self.result 
    
    def createData(self):
        for key in self.resultlist[0]:
            try:
                number = self.resultlist[0][key]+10
            except Exception as e:
                continue
            max_number = self.findMax(key)
            self.optimization(max_number,key)

    def optimization(self,divisor,key):
        for count in range (0 ,len(self.resultlist)):
            try:
                self.resultlist[count][key] /= divisor
            except Exception as e:
                print("zero can't be divided")

    def findMax(self, key):
        max = 0
        for count in range (0, len (self.resultlist)):
            if self.resultlist[count][key] > max :
                max = self.resultlist[count][key]
        return max