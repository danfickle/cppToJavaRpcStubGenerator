/* cppToJavaRpcStubGenerator (released under BSD license) by github.com/danfickle */

#ifndef JAVA_RPC_FWDS_H
#define JAVA_RPC_FWDS_H
#include <string>
#include <vector>
#include <stdint.h>
#ifdef RPC_USE_QT
#include <QSharedPointer>
#include <QWeakPointer>
#else
#include <boost/shared_ptr.hpp>
#include <boost/weak_ptr.hpp>
#endif
namespace cppToJavaRpc {
class Connection;
class JavaObjectId;
#ifdef RPC_USE_QT
typedef QSharedPointer<JavaObjectId> SafeJavaObjectIdPtr;
typedef QWeakPointer<JavaObjectId> WeakJavaObjectIdPtr;
#else
typedef boost::shared_ptr<JavaObjectId> SafeJavaObjectIdPtr;
typedef boost::weak_ptr<JavaObjectId> WeakJavaObjectIdPtr;
#endif
}
#endif
