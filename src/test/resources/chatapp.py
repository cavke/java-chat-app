# Locust configuration test file - used for stress testing REST API

import time, random
from locust import HttpUser, task, between

class QuickstartUser(HttpUser):
    wait_time = between(1, 2)

#    @task
#    def messages_read(self):
#        self.client.get("/api/messages")
        
    @task(10)
    def messages_send(self):
        for i in range(10):
            n = random.random()
            txt = f'This is a bla bla chat message that is created with some random number inside of it aaaaaaaaaaaaaaaaaaaaaaaa:: {n}'
            self.client.post("/api/messages", json={"createdBy": 1, "chatId": 1, "text": txt})
            time.sleep(1)

#    def on_start(self):
#        self.client.post("/api/login", json={"username":"test", "password":"test"})