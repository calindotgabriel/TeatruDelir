using System.Collections.Generic;
using TeatruDelir.Models;

namespace TeatruDelir
{
    public class UserRepository
    {
        public static List<User> GetAllUsers()
        {
            return MockFactory.GetMockUsers();
        }
    }
}