// Created by Călin Gabriel
// at 5:07 PM on 29/03/2016.
//  

using System.Data.Entity;
using TeatruDelir.Core.Repositories;
using TeatruDelir.Models;

namespace TeatruDelir.Persistence.Repositories
{
    public class UserRepository : Repository<User>, IUserRepository
    {
        public UserRepository(DbContext context) : base(context)
        {
        }
    }
}