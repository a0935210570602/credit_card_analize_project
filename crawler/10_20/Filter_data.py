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
    e3[ind0] = e3[ind0].split("$")[2]
    return e3[ind0].split("年")[0]
  else:
    return e3[ind0]
# 網購(5)-數位通路回饋上限
def get_crashback0_5(e3,x):
  ind0 = 0 + 3*(x)
  if "NT$NT$" in e3[ind0]:
    e3[ind0] = e3[ind0].split("$")[2]
    return e3[ind0].split("數")[0]
  else:
    return '0' 
# 信用卡首刷禮(6)
def get_crashback0_6(e3,x):
  ind0 = 0 + 3*(x)
  if "吋" in e3[ind0]:
    return e3[ind0].split("吋")[0]
  else:
    return '0' 
# 繳保費優惠(7)
def get_crashback0_7(e3,x):
  ind0 = 0 + 3*(x)
  if "NT$NT$" in e3[ind0]:
    e3[ind0] = e3[ind0].split("$")[2]
    return e3[ind0].split("/")[0]
  else:
    return '0' 
# 亞洲萬里通(8)
def get_crashback0_8(e3,x):
  ind0 = 0 + 3*(x)
  if "里" in e3[ind0]:
    return e3[ind0].split("里")[0]
  else:
    return '0' 
# 繳稅優惠(9)
def get_crashback0_9(e3,x):
  ind0 = 0 + 3*(x)
  e3[ind0] = e3[ind0].split("$")[2]
  return e3[ind0].split("最")[0]
# 紅利點數(10)
def get_crashback0_10(e3,x):
  ind0 = 0 + 3*(x)
  if "NT$NT$" in e3[ind0]:
    e3[ind0] = e3[ind0].split("$")[2]
    return e3[ind0].split("/")[0]
  else:
    return '0'

#得到國外回饋%數
def get_crashback1(e4,x):
  ind1 = 1 + 3*(x)
  return e4[ind1].split("%")[0]
# 哩程的(1)
def get_crashback1_1(e4,x):
  ind1 = 1 + 3*(x)
  e4[ind1] = e4[ind1].split("$")[2]
  return e4[ind1].split("/")[0]
# 加油的(2)
def get_crashback1_2(e4,x):
  ind1 = 1 + 3*(x)
  return e4[ind1].split("%")[0]
# 電影的(3)
def get_crashback1_3(e4,x):
  ind1 = 1 + 3*(x)
  return e4[ind1].split("折")[0]
# 分期零利率優惠(4)
def get_crashback1_4(e4,x):
  ind1 = 1 + 3*(x)
  return e4[ind1].split("期")[0]
# 網購(5)
def get_crashback1_5(e4,x):
  ind1 = 1 + 3*(x)
  return e4[ind1].split("%")[0]
# 信用卡首刷禮(6)
def get_crashback1_6(e4,x):
  ind1 = 1 + 3*(x)
  if "里" in e4[ind1]:
    return e4[ind1].split("里")[0]
  else:
    return '0' 
# 繳保費優惠(7)
def get_crashback1_7(e4,x):
  ind1 = 1 + 3*(x)
  if "無" in e4[ind1]:
    return '0'
  else:
    return e4[ind1].split("期")[0] 
# 亞洲萬里通(8)
def get_crashback1_8(e4,x):
  ind1 = 1 + 3*(x)
  if "NT$NT$" in e4[ind1]:
    e4[ind1] = e4[ind1].split("$")[2]
    return e4[ind1].split("/")[0] 
  else:
    return '0' 
# 繳稅優惠(9)
def get_crashback1_9(e4,x):
  ind1 = 1 + 3*(x)
  return e4[ind1].split("期")[0] 
# 紅利點數(10)
def get_crashback1_10(e4,x):
  ind1 = 1 + 3*(x)
  if "不適用" in e4[ind1]:
    return '0'
  else:
    return e4[ind1].split("哩")[0] 

#得到國內回饋%數(0)
def get_crashback2(e5,x):
  ind2 = 2 + 3*(x)
  return e5[ind2].split("%")[0]
# 哩程的(1)、加油的(2)
def get_crashback2_1(e5,x):
  ind2 = 2 + 3*(x)
  e5[ind2] = e5[ind2].split("$")[2]
  return e5[ind2].split("/")[0]
# 電影的的(3)
def get_crashback2_3(e5,x):
  ind2 = 2 + 3*(x)
  return e5[ind2].split("折")[0]
# 分期零利率優惠(4)
def get_crashback2_4(e5,x):
  ind2 = 2 + 3*(x)
  if "NT$NT$" in e5[ind2]:
    e5[ind2] = e5[ind2].split("$")[2]
    return e5[ind2].split("最")[0]
  else:
    return '0'
# 網購(5)
def get_crashback2_5(e5,x):
  ind2 = 2 + 3*(x)
  return e5[ind2].split("%")[0]
# 信用卡首刷禮(6)
def get_crashback2_6(e5,x):
  ind2 = 2 + 3*(x)
  if "NT$NT$" in e5[ind2]:
    e5[ind2] = e5[ind2].split("$")[2]
    return e5[ind2].split("首")[0]
  else:
    return '0'
# 繳保費優惠(7)
def get_crashback2_7(e5,x):
  ind2 = 2 + 3*(x)
  if "%" in e5[ind2]:
    return e5[ind2].split("%")[0]
  else:
    return '0'
# 亞洲萬里通(8)
def get_crashback2_8(e5,x):
  ind2 = 2 + 3*(x)
  if "NT$NT$" in e5[ind2]:
    e5[ind2] = e5[ind2].split("$")[2]
    return e5[ind2].split("/")[0]
  else:
    return '0'
# 繳稅優惠(9)
def get_crashback2_9(e5,x):
  ind2 = 2 + 3*(x)
  return e5[ind2].split("期")[0]
# 紅利點數(10)
def get_crashback2_10(e5,x):
  ind2 = 2 + 3*(x)
  if "不適用" in e5[ind2]:
    return '0'
  else:
    return e5[ind2].split("倍")[0]