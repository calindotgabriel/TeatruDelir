using System;
using TeatruDelir.Domain.Exception;
using TeatruDelir.Persistence.Repositories;

namespace TeatruDelir.Core.Controllers
{
    public class Controller
    {
        public static UserController LoginUser(string username, string password)
        {/*
            var users = UserRepository.GetAllUsers();
            var found = users.Find(u => u.Username == username);
            if (found == null)
            {
                throw new NoSuchUserException("Found no user w. username: " + username);
            }
            if (Hasher.Hash(password) != found.HashedPassword)
            {
                throw new BadUserPasswordException("Incorrect password");
            }
            if (found.IsManager)
            {
                return new ManagerUserController(found);
            }
            return new ClientUserController(found);*/
            throw new NotImplementedException();
        }
    }
}