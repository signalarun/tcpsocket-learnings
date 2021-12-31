import socket			

PORT = 7001
BUFFER_SIZE = 1024			

s = socket.socket()		
s.connect(('127.0.0.1', PORT))

# Receiving data from server
print (s.recv(BUFFER_SIZE).decode())

s.close()	
	
