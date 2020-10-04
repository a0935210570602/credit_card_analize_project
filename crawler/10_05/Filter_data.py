#e1: 擷取的資料
#將e1整理過後 return整理過後的第 x 筆資料 EX: 0 --> 第一筆

#得到銀行名
def get_bank_name(e1,x):
  # E1 = [e for e in e1]

  return e1[x].split(" ")[0]

#得到卡名
def get_card_name(e2,x):
  # E2 = [e for e in e2]

  y = e2[x].index(" ")
  return (e2[x])[y+1:]
  # return e2[x].split(" ")[1]

#得到年費
def get_annual_fee(e3,x):
  ind0 = 0 + 3*(x)
  if "NT$NT$" in e3[ind0]:
    return e3[ind0].split("$")[2]
  else:
    return e3[ind0]

#得到國外回饋%數
def get_crashback1(e4,x):
  ind1 = 1 + 3*(x)

  return e4[ind1].split("國")[0]

#得到國內回饋%數
def get_crashback2(e5,x):
  ind2 = 2 + 3*(x)

  return e5[ind2].split("國")[0]