package org.example.models;

public class User
{
        private int id;
        private String name;
        private String phoneNumber;
        private String password;

        public int GetId()
        {
                return id;
        }

        public void SetId(int id)
        {
                this.id = id;
        }

        public String GetName()
        {
                return name;
        }

        public void SetName(String name)
        {
                this.name = name;
        }

        public String GetPhoneNumber()
        {
                return phoneNumber;
        }

        public void SetPhoneNumber(String phoneNumber)
        {
                this.phoneNumber = phoneNumber;
        }

        public String GetPassword()
        {
                return password;
        }

        public void SetPassword(String password)
        {
                this.password = password;
        }
}
