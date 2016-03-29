// Created by Călin Gabriel
// at 4:54 PM on 29/03/2016.
//  

using System;
using System.Data.Entity;
using TeatruDelir.Models;
using TeatruDelir.Persistence.EntityConfigurations;

namespace TeatruDelir.Persistence
{
    public class DelirContext : DbContext
    {
        public DelirContext()
            : base("name=DelirContext")
        {
            Configuration.LazyLoadingEnabled = false;
        }

        public DbSet<User> Users{ get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new UserConfiguration());
        }
    }
}