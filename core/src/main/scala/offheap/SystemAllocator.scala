package offheap

import offheap.internal.Memory.UNSAFE

/** Underyling OS allocator that does not attempt
 *  to perform any automatic memory management
 *  (all allocations must have accompanied calls to free.)
 */
object SystemAllocator extends Allocator {
  def allocate(size: Size): Addr               = UNSAFE.allocateMemory(size)
  def reallocate(addr: Addr, size: Size): Addr = UNSAFE.reallocateMemory(addr, size)
  def free(addr: Addr): Unit                   = UNSAFE.freeMemory(addr)
}
