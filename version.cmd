SET string = git branch | find "*"
SET branch = %string:~-2%

ECHO %branch%