# EmailApp
Project Java : Encapsulation and Data binding and Data hiding

In this application the follwoing scenario is addressed :
Email Project : Java Project

Use-case : Being a IT administrator Specialist you are incharged with the task of creating new email accounts for the new hires

The email application should do the following:
Generate an email with the following syntax : firstname.lastname@department.company.com
Determine the department : sales , development, accounting. If none, leave blank
Generate a random String for password
Have set methods to change the password, set the mailbox capacity, and define an alternative email address.
Have get methods to display name, email address and mailbox capacity.

The EmailApp project focusses on Encapsulation, data binding and data hiding concepts of Java.
The data members of the Email App are kept private and menthods to set values to data members are made private so that only within Email class the access of data members are allowed , this implements Encapsulation.
The methods inside a java class have bindings of data members available using the `this` keyword. 
For having the concept of data hiding few public getter methods are exposed from within the EmailApp that allows access of private data member values outisde of class.

