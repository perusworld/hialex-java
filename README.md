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
Replace hialex-java with something you like

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


### Test
