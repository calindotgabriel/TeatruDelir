// Created by Călin Gabriel
// at 5:00 PM on 29/03/2016.
//  

using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Linq.Expressions;
using TeatruDelir.Core.Repositories;

namespace TeatruDelir.Persistence.Repositories
{
    public class Repository<TEntity> : IRepository<TEntity> where TEntity : class
    {
        protected readonly DbContext Context;

        protected DbSet<TEntity> Entities;

        public Repository(DbContext context)
        {
            Context = context;
            Entities = Context.Set<TEntity>();
        }

        public TEntity Get(int id)
        {
            return Entities.Find(id);
        }

        public IEnumerable<TEntity> GetAll()
        {
            return Entities.ToList();
        }

        public IEnumerable<TEntity> Find(Expression<Func<TEntity, bool>> predicate)
        {
            return Entities.Where(predicate);
        }

        public TEntity SingleOrDefault(Expression<Func<TEntity, bool>> predicate)
        {
            return Entities.SingleOrDefault(predicate);
        }

        public void Add(TEntity entity)
        {
            Entities.Add(entity);
        }

        public void AddRange(IEnumerable<TEntity> entities)
        {
            Entities.AddRange(entities);
        }

        public void Remove(TEntity entity)
        {
            Entities.Remove(entity);
        }

        public void RemoveRange(IEnumerable<TEntity> entities)
        {
            Entities.RemoveRange(entities);
        }
    }
}