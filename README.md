# hialex-java
Hello World - Alexa - Spring Boot - Heroku

## 
Make sure you have setup [ing Boot CLI](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started-installing-the-cli), [Heroku Command Line](https://devcenter.heroku.com/articles/heroku-command-line) and [Amazon Developer Console](https://developer.amazon.com)

### Code
Checkout the code

### Launch on Heroku
Go to the checkout directory and,
run the following to create an app on heroku 
```bash
heroku create hialex-java
```
Replace **hialex-java** with something you like

then run the following to push to heroku repo
```bash
git push heroku master
```
This will push , start the app and show you the url at which the app can be accessed, note the url.

### Alexa Skills Kit
Configure a new alexa skill, at the interaction model page use the following for this example

#### Intent Schema
```json
{
	"intents": [
		{
			"intent": "Hello",
			"slots": []
		},
		{
			"intent": "HelloMe",
			"slots": [
				{
					"name": "Who",
					"type": "AMAZON.US_FIRST_NAME"
				}
			]
		},
		{
			"intent": "Add",
			"slots": [
				{
					"name": "NumberA",
					"type": "AMAZON.NUMBER"
				},
				{
					"name": "NumberB",
					"type": "AMAZON.NUMBER"
				}
			]
		}
	]
}
```

#### Sample Utterances
```text
Hello Hello
Hello Hi
Hello Hi There
Hello What's Up
Hello Howdy

HelloMe I am {Who}
HelloMe This is {Who}

Add Add {NumberA} and {NumberB}
Add Sum {NumberA} and {NumberB}
```

### Endpoint Configuration
At the configuration page, select **https** endpoint type, select the region where the heroku app is running and enter the url you got when you pushed the heroku app, append **/hialex** to the url

```text
example - https://hialex-java.herokuapp.com/hialex
```

### SSL Configuration
For the Certification Endpoint configuration select the option **My development endpoint is a sub-domain of a domain that has a wildcard certificate from a certificate authority**

### Test
You can test the flow at the Test page under **Service Simulator**

Use the following to test the 3 intents configured 

1. hi (should return you Welcome)

1. i am peru (should return Welcome Peru)

1. add twelve and thirteen (should return The sum of the two numbers are 25)


