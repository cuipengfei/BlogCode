---
pinned: true
tags: [aws, iam, Notebooks/AWS]
title: Udemy AWS
created: '2019-08-29T14:05:03.863Z'
modified: '2019-09-27T09:01:52.027Z'
---

# Udemy AWS

## IAM

* How to force all IAM users to use MFA?

* Relationship between key concepts of IAM. (user, group, role, policy)

Roles are more secure than saving access key id and secret access key.
Roles can be assigned to EC2.
Roles are global, can be used in all regions.

Can use roles to grant access, safer than access key id and secret key.

## S3

* object storage vs file storage vs block storage

* read S3 FAQ

### Consistency

write new, immediately

update, eventual consistency

### Storage classes

based on access frequency

### Cross region replication

versioning must be turned on

delete does not get repliated

existing objects do not get replicated

### Transfer accelaration

by using edge location, can put to edge location

* need to be turned on/off? or is it applied by default?

### Lifecycle Rule

change storage class tier

# EC2

## pricing

on demand, no up front payment

choosing subnet when creating ec2 instance is choosing an availability zone in the region.

security group is a virtual firewall

security group changes take effect immediately

security group is stateful, if you create inbound rule to allowed inbound on 8080, automatically can outbound 8080 as well.

## CloudWatch

monitor and alarm

CloudTrail, recording who did what when (api calls record)

## Placement group

clustered: same availability zone, close, together
spread: kept separate from each other

# EBS

elastic block store

## instance store vs EBS

instance store backed ec2 isntances can not be stopped, failure causes lose of data

# RDS

* RDS CAP?

Multi AZ fail over, dns update, no need to change connection string. Used for disaster recovery.

Read replica, for throuput/performance. Write to one, read from different replicas. Can be in a different region.

Data warehouse for BI, AWS RedShift

ElastiCache, supports redis and memcached


