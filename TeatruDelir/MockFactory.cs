// Created by Călin Gabriel
// at 2:51 PM on 20/03/2016.
//  

using System.Collections.Generic;
using TeatruDelir.Models;

namespace TeatruDelir
{
    public class MockFactory
    {
        private static User _clientUser;
        private static User _managerUser;

        public static List<User> GetMockUsers()
        {
            var users = new List<User>();
            _clientUser = new User()
            {
                Id = MockIds.GetNextId(),
                Username = "calinxgabriel",
                HashedPassword = Hasher.Hash("motan"),
                Name = "Calin Gabriel",
                Address = "Str. Oltului nr 43",
                IsManager = false
            };
            _managerUser = new User()
            {
                Id = MockIds.GetNextId(),
                Username = "admin",
                HashedPassword = Hasher.Hash("admin"),
                Name = "George Washington",
                Address = "Str. Oltului nr 43",
                IsManager = true
            };
            users.Add(_clientUser);
            users.Add(_managerUser);
            return users;
        }

        public static User RandomManager()
        {
            return _managerUser;
        }
    }
}