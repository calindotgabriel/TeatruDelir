// Created by Călin Gabriel
// at 7:11 PM on 28/03/2016.
//  

using System;
using System.Collections.Generic;
using System.Linq.Expressions;

namespace TeatruDelir.Core.Repositories
{
    public interface IRepository<TEntity> where TEntity : class 
    {
        TEntity Get(int id);
        IEnumerable<TEntity> GetAll();
        IEnumerable<TEntity> Find(Expression<Func<TEntity, bool>> predicate);

        // This method was not in the videos, but I thought it would be useful to add.
        TEntity SingleOrDefault(Expression<Func<TEntity, bool>> predicate);

        void Add(TEntity entity);
        void AddRange(IEnumerable<TEntity> entities);

        void Remove(TEntity entity);
        void RemoveRange(IEnumerable<TEntity> entities);
    }
}