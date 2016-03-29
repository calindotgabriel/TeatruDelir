// Created by Călin Gabriel
// at 7:32 PM on 28/03/2016.
//  

using TeatruDelir.Core;
using TeatruDelir.Core.Repositories;
using TeatruDelir.Persistence.Repositories;

namespace TeatruDelir.Persistence
{
    public class UnitOfWork : IUnitOfWork
    {
        private readonly DelirContext _context;

        public UnitOfWork(DelirContext context)
        {
            _context = context;
            Users = new UserRepository(_context);
        }

        public IUserRepository Users { get; private set; }

        public int Complete()
        {
            return _context.SaveChanges();
        }

        public void Dispose()
        {
            _context.Dispose();
        }
    }
}