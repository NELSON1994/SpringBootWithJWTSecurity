# SpringBootWithJWTSecurity
Simple API that is being secured using Json Web Token to access other APIs
The password has not been encrypted so we are using NoPasswordEncryption for Passwords.
The request must be sent to an API /authenticate with the username and password which when are valid on db, Auth Token will be generated for that user to access other end points
The token has been set to have 10 hrs validity
