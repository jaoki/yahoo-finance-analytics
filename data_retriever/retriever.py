import requests 
from pprint import pprint

def retrieve_raw_json_data():
    url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.historicaldata%20where%20symbol%20%3D%20%22YHOO%22%20and%20startDate%20%3D%20%222009-09-11%22%20and%20endDate%20%3D%20%222010-03-10%22&format=json&diagnostics=true&env=http%3A%2F%2Fdatatables.org%2Falltables.env&callback="
    response = requests.get(url)
    return response.json()

def group_by_month(json_data):
    return json_data["query"]["results"]["quote"]

def main():
    json_data = retrieve_raw_json_data()
    json_data = group_by_month(json_data)
    pprint(json_data)

main()
