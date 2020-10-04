import urllib.request as req
from bs4 import BeautifulSoup

def get_num_of_card(url):
    #1
    request = req.Request(url,headers={
        "User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36"
    })
    with req.urlopen(request) as response: 
        data=response.read().decode('utf8')
    #2
    soup = BeautifulSoup(data, 'html.parser')
    contents = soup.find_all(["h2"])
    #3
    num_of_card = [e.text for e in contents]
    print(num_of_card[0])
    num = num_of_card[0].split(" ")[0]
    print(num)

    return num