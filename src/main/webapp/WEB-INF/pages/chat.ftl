<#import "/spring.ftl" as spring />
<script src="<@spring.url '/resources/stomp.js' />"></script>
<script src="<@spring.url '/resources/sockjs-0.3.4.js'/>"></script>
<script type="text/javascript">
    var stompClient = null;
    var authorId = ${author.id};
    var companionId;

    function setConnected(connected) {
        document.getElementById('opponent').disabled = connected;
        document.getElementById('connect').disabled = connected;
        document.getElementById('disconnect').disabled = !connected;
        document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
        document.getElementById('messages').innerHTML = '';
    }

    function connect() {
        var socket = new SockJS('/chat');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            setConnected(true);
            console.log('Connected: ' + frame);
            companionId = getSelectedItemValue();
            stompClient.subscribe('/topic/messages', function(messaging){
                if(JSON.parse(messaging.body).authorId==companionId&JSON.parse(messaging.body).companionId==authorId){
                    showMessage(getSelectedItemText()+' : '+JSON.parse(messaging.body).message);
                }
                if(JSON.parse(messaging.body).authorId==authorId&JSON.parse(messaging.body).companionId==companionId){
                    showMessage('${author.login} : '+JSON.parse(messaging.body).message);
                }

            });
        });
    }

    function disconnect() {
        stompClient.disconnect();
        setConnected(false);
        console.log("Disconnected");
    }

    function sendName() {
        var message = document.getElementById('message').value;
        stompClient.send("/app/chat", {}, JSON.stringify({ 'message': message, 'authorId' : authorId,
            'companionId': companionId, 'date' : new Date()}));
    }

    function showMessage(message) {
        var response = document.getElementById('messages');
        var p = document.createElement('p');
        p.style.wordWrap = 'break-word';
        p.appendChild(document.createTextNode(message));
        response.appendChild(p);
    }

    function getSelectedItemValue(){
        var sel = document.getElementById("opponent");
        for(var count= sel.options.length-1; count >= 0; count--) {
            if (sel.options[count].selected == true) {
                return sel.options[count].value;
            }
        }
    }
    function getSelectedItemText(){
        var sel = document.getElementById("opponent");
        for(var count= sel.options.length-1; count >= 0; count--) {
            if (sel.options[count].selected == true) {
                return sel.options[count].text;
            }
        }
    }
</script>
<html>
<head>
    <title>Chat</title>
</head>
<body>
Logged as: ${author.login}
<br>
Select the opponent:
<select id="opponent">
<#list list as rival>
        <#if rival.login!=author.login>
            <option value="${rival.id}">${rival.login}
        </#if>
</#list>
</select>
<br>
<button id="connect" onclick="connect();">Connect</button>
<button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
<div id="conversationDiv" style="visibility: hidden">
    <label>Enter your message</label><input type="text" id="message" />
    <button id="sendName" onclick="sendName();">Send</button>
    <p id="messages"></p>
</body>
</html>
