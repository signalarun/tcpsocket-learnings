import socket            
 
PORT = 7001  

s = socket.socket()        
print ("Socket successfully created")
 
s.bind(('', PORT))        
print ("Using %s" %(PORT))
 
s.listen(5)    
print ("Listening..")           

while True:
  
  c, addr = s.accept()    
  print ('Connected client ', addr )
  
  c.send('Thank you for connecting'.encode())
  c.close()
   
  break
s.close()