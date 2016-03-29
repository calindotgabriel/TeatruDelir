// Created by Călin Gabriel
// at 7:24 PM on 28/03/2016.
//  

using System;
using TeatruDelir.Core.Repositories;

namespace TeatruDelir.Core
{
    public interface IUnitOfWork : IDisposable
    {
        IUserRepository Users { get; }

        int Complete();
    }
}