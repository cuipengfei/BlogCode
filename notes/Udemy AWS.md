---
pinned: true
tags: [aws, iam, Notebooks/AWS]
title: Udemy AWS
created: '2019-08-29T14:05:03.863Z'
modified: '2019-09-04T08:04:00.062Z'
---

# Udemy AWS

## IAM

* How to force all IAM users to use MFA?

* Relationship between key concepts of IAM. (user, group, role, policy)

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

# EBS

elastic block store

## instance store vs EBS

instance store backed ec2 isntances can not be stopped, failure causes lose of data
