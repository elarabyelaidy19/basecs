# Recovery 
Recovery manager is in charge of atomicity and durability of the data. It is responsible for ensuring that data is not lost in the event of a system failure. and rollback of Xact that violates consistency.

if a transaction is aborted, the recovery manager will rollback the changes made by the aborted transaction. 

## Why Xact is abort? 
**application** can abort Xact if there is a problem with the data. exception handled. 
**Failed consistency**: integrity constraint violation. delete a row that is referenced by another row.
**Deadlock**: abort Xact that conflict other Xact. 
**System failure**: system crash. power failure. 

## Transaction and SQL

### Savepoints 
- release savepoint: release all the changes made after the savepoint. 
- rollback to savepoint: rollback all the changes made after the savepoint. 

## DataBase Crash
- operator errors: type wrong command, plug out the power. 
- connection errors: insufficent resources disk space. file permissions. 
- software errors: bug in the code.  
- Hardware errors: disk failure. server hardware failure. 

## Buffer Manager 
- **No STEAL Policy**: do not allow buffer-pool frame with uncommited updates to be replaced. 
- **FORCE Policy**: make sure that every update is enforced to disk before commit. 

The prefered policy is **STEAL/NO-FORCE**.

## Write Ahead Log 
every update is written to the log disk to allow REDO/UNDO. multiple updates written to single log page.
A log is a sequence of log records that describethe operations that the database has done. 
- Log record contains:
    - <TXID, pageID, old data, new data> 

### Policy 
- write to log before write to disk. **UNDO**
- write all the log records to the log before commit. **REDO** 
**UNDO**: guranatee atomicity.
**REDO**: guranatee durability.

## The Log  
an orderd file with a write buffer in ram. each log record has a unique log sequence number**LSN**. and **flushdLSN** that indicate the number of log record flushed to memory. and **PageLSN** pointer on disk that point to the last log record for an update to that page.

## Undo Logging
undo Xact that have not been committed. uses the force and steal policy. 
- **STEAL** if Xact modified X, then <T,X,N> must be written to log disk before commit.
- **FORCE** if Xact commit then dirty page must be written to disk before commit.

**Example**: 
if Xact modified X, then flushed to disk and crashed before commit it will be undo.
if Xact commit then flushed to disk and crashed after commit nothing to do. data written to disk.

## REDO Logging 
at recovery time, REDO the Txns that have been committed. and leave the uncommitted Txns. 
- **No-STEAL**: if Xact modified X, then <T,X,N> must be written to log disk before before dirty pages written to disk. 

**Example**: 
if Xact modified X, then committed and the system crash Redo the Txn. 
if Xact modified X, and crached before committing do nothing. 
