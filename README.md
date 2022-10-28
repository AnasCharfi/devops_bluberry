# devops_bluberry
## Welcome to BluBerry DevOps project

 #### Below you'll find commands and instructions to run the project
<ol>
    <li>Start <strong>vagrant</strong> in powershell: 
        <ul>
            <li><strong>vagrant up</strong></li>
            <li><strong>vagrant ssh</strong></li>
        </ul>
    </li>
    <li>Get to know your <strong>ip address</strong> in <em>vagrant</em>: 
        <ul>
            <li><strong>ip addr show</strong></li>
            <li><strong>copy and paste it in the browser you'll need it, we'll call it ### for the rest of the guide</strong><em> #mandatory</em></li>
        </ul>
    </li>   
    <li>Start <strong>jenkis</strong> in <em>vagrant</em>: 
        <ul>
            <li><strong>systemctl start jenkins</strong></li>
            <li><strong>systemctl status jenkins</strong><em> #Not mandatory</em></li>
            <li><strong>now open your browser, type in ###:8080</strong></li>
        </ul>
    </li>   
    <li>Start <strong>Sonar</strong> in <em>vagrant</em> on <em>Docker</em>: 
        <ul>
            <li><strong>docker run -p 9000:9000 sonarqube:8.9.7-community</strong><br><em> #It will take some time don't worry <br>#Also we're using this specific version because the last version isn't really stable</em></li>
            <li><strong>now open your browser, type in ###:9000</strong></li>
        </ul>
    </li>    
        <li>Start <strong>Nexus3</strong> in <em>vagrant</em> on <em>Docker</em>: 
        <ul>
            <li><strong>docker run -d -p 8081:8081 sonatype/nexus3</strong><br><em> #It will take some time (quiet much) don't worry</em></li>
            <li><strong>now open your browser, type in ###:8081</strong>
            </li>
            <li><strong>docker exec -i  cat /nexus-data/admin.password</strong><em> #Now get the password by typing this command</em><br><em>#Sometimes nexus doesn't and sonar doesn't save the new password that's why this message exists</em></li>
        </ul>
    </li>    

</ol> 

##### Below you'll find some commands that will help you out
<ul>
    <li>docker images</li>
    <li>docker ps</li>
    <li>docker images show</li>
</ul>

##### I hope that this guide will be helpfull and if you needed any sort of help!

- 💼 Do reach by [email](mailto:charfianas1@gmail.com) 😀
- 📞 or by Whatsapp [+21653072794](https://api.whatsapp.com/send?phone=21653072794&text=Hello%20from%20Anas%20Charfi%20website!)
- 💬 ask me about anything, I'm always happy to help

<br>


### Friendly reminder to support
* Tap Follow on the left and you will make my day
* Consider leaving a :star: on the most interesting repository
<br>
