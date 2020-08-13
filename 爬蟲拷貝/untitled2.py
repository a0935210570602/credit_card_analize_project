import urllib.request as req
url="https://rich01.com/all-credit-cards-suggest/"
with req.urlopen(url) as response:
    data=response.read().decode("utf-8")

import bs4
root=bs4.BeautifulSoup(data, "html.parser")
titles=root.find_all(["h2", "span" , "font-weight: 400;"])
cards=root.find_all(["tr", "td"])
for title in titles:
    print(title.string)
for card in cards:
    print(card.string)

    
    