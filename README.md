# speaking-clock
Take the digital inputs of the clocks converts those into words

Get URL for api endpoint 
Sample request
http://localhost:8080/clock?time=8:45
pass the request param in key value pair or use above URL to fire clock api


Example :

input 1
GET request : http://localhost:8080/clock?time=23:59

response :

{
    "speakDayTime": "",
    "statusMessage": "SUCCESS",
    "speakTime": "ITS ELEVEN FIFTY NINE PM"
}





